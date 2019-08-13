/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.kotlin_movie_app.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Movie class represents video entity with title, description, image thumbs and video url.
 */
class Movie @JsonCreator
constructor(
    @param:JsonProperty("rank") val rank: Int,
    @param:JsonProperty("title") val title: String,
    @param:JsonProperty("year") val year: Int,
    @param:JsonProperty("imdbId") val imdbId: String,
    @param:JsonProperty("imdbRating") val imdbRating: Double,
    @param:JsonProperty("imdbVotes") val imdbVotes: Int,
    @param:JsonProperty("poster") val poster: String,
    @param:JsonProperty("imdbLink") val imdbLink: String
)

