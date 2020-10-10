name := "Simple Project"

version := "1.0"

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"

// This library enables easy REPL debugging, similar to Python's breakpoint()
libraryDependencies += "com.lihaoyi" % "ammonite" % "2.2.0" cross CrossVersion.full

// assemblyMergeStrategy in assembly := {
//     case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
//     // case PathList("org", "apache", xs @ _*) => MergeStrategy.last
//     // case PathList("com", "google", xs @ _*) => MergeStrategy.last
//     // case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
//     // case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
//     // case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
//     case "about.html" => MergeStrategy.rename
//     case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
//     case "META-INF/mailcap" => MergeStrategy.last
//     case "META-INF/mimetypes.default" => MergeStrategy.last
//     case "plugin.properties" => MergeStrategy.last
//     case "log4j.properties" => MergeStrategy.last
//     case x =>
//         val oldStrategy = (assemblyMergeStrategy in assembly).value
//         oldStrategy(x)
// }

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}