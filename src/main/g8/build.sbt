name := "$name;format="normalize"$"

version := "0.1"

scalaVersion := "$app_version$"

val sparkVersion = "$spark_version$"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided"
)
