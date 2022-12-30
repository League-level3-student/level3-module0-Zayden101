/*
 * Copyright (c) 2020, <dinglemouse> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _07_The_Wrong_Way_Cow;

import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Instructions for this assignment are in TheWrongWayCow.java file
 */
public class TheWrongWayCowTest {

  // show the field
  private static char[][] show(final char[][] field) {
    for (int i = 0; i < field.length; i++) {
      System.out.println(new String(field[i]));
    }
    return field;
  }
  
  @Test
  public void simple() {
    final char[][] field = new char[][] {
      "cowc".toCharArray(),
      "cowo".toCharArray(),
      "coww".toCharArray(),
      "cow.".toCharArray(),
      };
    assertArrayEquals(new int[]{3,0}, TheWrongWayCow.findWrongWayCow(show(field)));
  }

  @Test
  public void ex1() {
    final char[][] field = new char[][] {
      "cow.cow.cow.cow.cow".toCharArray(),
      "cow.cow.cow.cow.cow".toCharArray(),
      "cow.woc.cow.cow.cow".toCharArray(),
      "cow.cow.cow.cow.cow".toCharArray(),
      };
    assertArrayEquals(new int[]{6,2}, TheWrongWayCow.findWrongWayCow(show(field)));
  }

  @Test
  public void ex2() {
    final char[][] field = new char[][] {
      "c..........".toCharArray(),
      "o...c......".toCharArray(),
      "w...o.c....".toCharArray(),
      "....w.o....".toCharArray(),
      "......w.cow".toCharArray()
      };
    assertArrayEquals(new int[]{8,4}, TheWrongWayCow.findWrongWayCow(show(field)));
  }

  @Test
  public void aFieldFullOfJunk() {
    final char[][] field = new char[][] {
      "30987 4903247497947947 494797c".toCharArray(),
      "3249874 4978349 (*&(& 9797&(&o".toCharArray(),
      "^^*cowg*9870)*08-090-9-9 --9-w".toCharArray(),
      "*&^*(&^*&(### @@@@@ 2220349409".toCharArray(),
      "E908E09850 080484844992 293983".toCharArray(),
      "0098 080 KLcowDSFLHU EWPEEJELK".toCharArray(),
      " dfhdu 880-23fjdlfkjlkjlkjfljf".toCharArray(),
      ";d43-02- -340-2394 39-099kk;ld".toCharArray()
    };
    assertArrayEquals(new int[]{29,0}, TheWrongWayCow.findWrongWayCow(show(field)));
  }

  @Test 
  public void wwcW() {
    final char[][] field = new char[][] {
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowc..cowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowo..cowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcoww..cowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray(),
      "cowcowcowcowcowcowcowcowcowcowcowcowcowcowcowcow".toCharArray()
    };
    assertArrayEquals(new int[]{9,5}, TheWrongWayCow.findWrongWayCow(show(field)));
  }

@Test
public void wwcE() {
  final char[][] field = new char[][] {
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwocwoc".toCharArray(),
    "wocwocwocwocwocwocwocwocwoccow".toCharArray()
  };
  assertArrayEquals(new int[]{27,15}, TheWrongWayCow.findWrongWayCow(show(field)));
}

@Test
public void wwcN() {
  final char[][] field = new char[][] {
  "cccccccccccccccccccccccccccccc".toCharArray(),
  "oooooooooooooooooooooooooooooo".toCharArray(),
  "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
  "cccccccccccccccccccccccccccccc".toCharArray(),
  "oooooooooooooooooooooooooooooo".toCharArray(),
  "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
  "ccccccccccccccwccccccccccccccc".toCharArray(),
  "oooooooooooooooooooooooooooooo".toCharArray(),
  "wwwwwwwwwwwwwwcwwwwwwwwwwwwwww".toCharArray(),
  "cccccccccccccccccccccccccccccc".toCharArray(),
  "oooooooooooooooooooooooooooooo".toCharArray(),
  "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
  "cccccccccccccccccccccccccccccc".toCharArray(),
  "oooooooooooooooooooooooooooooo".toCharArray(),
  "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray()
  };
  assertArrayEquals(new int[]{14,8}, TheWrongWayCow.findWrongWayCow(show(field)));
}

@Test
public void wwcS() {
  final char[][] field = new char[][] {
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray(),
    "www...wwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "ooocowoooooooooooooooooooooooo".toCharArray(),
    "ccc...cccccccccccccccccccccccc".toCharArray(),
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray(),
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray(),
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray(),
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray(),
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww".toCharArray(),
    "oooooooooooooooooooooooooooooo".toCharArray(),
    "cccccccccccccccccccccccccccccc".toCharArray()
  };
  assertArrayEquals(new int[]{3,4}, TheWrongWayCow.findWrongWayCow(show(field)));
}

@Test 
public void mostlyEmpty() {
  final char[][] field = new char[][] {
    "cow...........................".toCharArray(),
    "..............................".toCharArray(),
    "..............................".toCharArray(),
    "........w.....................".toCharArray(),
    "........o.....................".toCharArray(),
    "........c.....................".toCharArray(),
    "..............................".toCharArray(),
    ".............................w".toCharArray(),
    ".............................o".toCharArray(),
    ".............................c".toCharArray()
  };
  assertArrayEquals(new int[]{0,0}, TheWrongWayCow.findWrongWayCow(show(field)));
}

}