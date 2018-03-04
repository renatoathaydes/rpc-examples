package com.athaydes.tutorials.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import spark.Spark;

import java.util.Map;

public class Main {

    public static void main( String[] args ) {
        SchemaParser schemaParser = SchemaParser.newParser()
                .file( "hello_world.graphqls" )
                .resolvers( new Query(), new HelloResolver() )
                .build();

        GraphQLSchema executableSchema = schemaParser.makeExecutableSchema();
        GraphQL graphQL = GraphQL.newGraphQL( executableSchema ).build();

        Gson gson = new Gson();

        // expose the GraphQL engine using a HTTP server
        Spark.get( "/graphql-api", "application/json", ( req, res ) -> {
            Map<String, Object> variables = gson.fromJson(
                    req.queryParamOrDefault( "variables", "{}" ),
                    new TypeToken<Map<String, Object>>() {
                    }.getType() );

            ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                    .query( req.queryParams( "query" ) )
                    .variables( variables )
                    .build();

            ExecutionResult result = graphQL.execute( executionInput );

            res.header( "Content-Type", "application/json" );
            return gson.toJson( result );
        } );
    }

}
