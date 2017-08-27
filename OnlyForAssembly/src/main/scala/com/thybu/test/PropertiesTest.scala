package com.thybu.test

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.spark.{SparkConf, SparkContext}

object PropertiesTest {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf()
      .setAppName("PropertiesTest")

    val config = ConfigFactory.load()

    val sc = new SparkContext(sparkConf)
    println("User: " + config.getString("s3.secret")  + ", secret: " + config.getString("s3.key") )

  }


}