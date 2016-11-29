/*
 * Copyright 2016 Daniel Urban
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

package io.sigs.seals
package circe

import io.circe._

import io.sigs.seals.core.Wire

trait Wires {

  implicit def wireFromReified[A](
    implicit A: Reified[A]
  ): Wire.Aux[A, Json, DecodingFailure] = new Wire[A] {
    type Repr = Json
    type Err = DecodingFailure

    override def toWire(a: A): Either[DecodingFailure, Json] =
      Right(Codec.encoderFromReified(A).apply(a))

    override def fromWire(r: Json): Either[DecodingFailure, A] =
      Codec.decoderFromReified(A).decodeJson(r)

    override def reified = A
  }
}

object Wires extends Wires
