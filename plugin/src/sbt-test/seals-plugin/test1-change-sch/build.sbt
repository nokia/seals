/*
 * Copyright 2017-2020 Daniel Urban and contributors listed in AUTHORS
 * Copyright 2020 Nokia
 * SPDX-License-Identifier: Apache-2.0
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

name := "test1"

organization := "com.example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.12"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch)

libraryDependencies += "dev.tauri" %% "seals-core" % System.getProperty("plugin.version")

sealsSchemaPackages += "com.example.test1"

mimaPreviousArtifacts := Set(organization.value %% name.value % version.value)
