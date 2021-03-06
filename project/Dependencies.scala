/*
 * Copyright 2019-2020 Radicalbit S.r.l.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._
import Keys._

object Dependencies {

  object kafka {
    private lazy val version   = "1.1.1"
    private lazy val namespace = "org.apache.kafka"
    lazy val connect           = namespace % "connect-api" % version excludeAll ExclusionRule(organization = "javax.ws.rs")
  }

  object kcql {
    private lazy val version   = "2.8"
    private lazy val namespace = "com.datamountaineer"
    lazy val kcql              = namespace % "kcql" % version
  }

  object nsdb {
    lazy val namespace = "io.radicalbit.nsdb"
    lazy val  scalaAPI = Def.setting { namespace %% "nsdb-scala-api" % (ThisBuild / version).value excludeAll
      (ExclusionRule(organization = "com.fasterxml.jackson.core"),
        ExclusionRule(organization = "com.fasterxml.jackson.module"),
        ExclusionRule(organization = "com.fasterxml.jackson.datatype"))}
  }

  object scalatest {
    lazy val version   = "3.0.7"
    lazy val namespace = "org.scalatest"
    lazy val core      = namespace %% "scalatest" % version
  }

  object circe {
    lazy val version = "0.11.1"
    lazy val namespace = "io.circe"
    lazy val core = namespace %% "circe-core" % version
    lazy val generic = namespace %% "circe-generic" % version
    lazy val parser = namespace %% "circe-parser" % version
  }

  object `cats-retry` {
    lazy val version   = "0.3.1"
    lazy val namespace = "com.github.cb372"
    lazy val core      = namespace %% "cats-retry-core" % version
    lazy val effect    = namespace %% "cats-retry-cats-effect" % version
  }

  lazy val libraries = Seq(
    kafka.connect % Provided,
    kcql.kcql,
    circe.core,
    circe.generic,
    circe.parser,
    `cats-retry`.core,
    `cats-retry`.effect,
    scalatest.core % Test
  )
}
