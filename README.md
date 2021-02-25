# 1803-spring-cloud-config
Bug reproduction

 - config-server and config-client apps from initizializr with basic config for running locally
 - the config-server can be updated with a `searchPath` of `sub`, which should change the client `/message`
 - expecting a POST to `/actuator/refresh` on the client to pickup this change from the server
