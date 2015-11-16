/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer.hls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Represents an HLS master playlist.
 */
public final class HlsMasterPlaylist extends HlsPlaylist {

  public final List<Variant> variants;
  public final List<Subtitle> subtitles;

  public HlsMasterPlaylist(String baseUri, List<Variant> variants, List<Subtitle> subtitles) {
    super(baseUri, HlsPlaylist.TYPE_MASTER);
    //variants.remove(1);variants.remove(1);variants.remove(1);//variants.remove(1);
    //ArrayList<Variant> l = new ArrayList<Variant>(2);
    //l.add(variants.get(0));
    //l.add(variants.get(4));
    this.variants = variants;

    this.subtitles = subtitles;
  }

}
