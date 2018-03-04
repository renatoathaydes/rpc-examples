@Grab( "com.athaydes.rawhttp:rawhttp-core:1.1.0" )
import com.athaydes.rawhttp.core.*
import com.athaydes.rawhttp.core.client.TcpRawHttpClient

query = URLEncoder.encode '''query($n:String!) {
  sayHelloAgain(name: $n) {
    name
    message
  }
}''', 'UTF-8'

variables = URLEncoder.encode '{"n": "Michael"}', 'UTF-8'

client = new TcpRawHttpClient()

req = new RawHttp().parseRequest( """\
GET localhost:4567/graphql-api?query=$query&variables=$variables HTTP/1.1
Accept: application/json
User-Agent: rawhttp
""" )

println client.send( req ).eagerly()

client.close()