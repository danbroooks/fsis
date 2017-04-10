name := "fsis"

scalaVersion := "2.11.7"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.3" cross CrossVersion.binary)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.10.0"
