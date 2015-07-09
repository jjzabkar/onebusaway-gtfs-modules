/**
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.gtfs.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AgencyAndIdTest {

  @Test
  public void testConvertFromString() {
    
    AgencyAndId id = AgencyAndId.convertFromString("a_b");
    assertEquals("a",id.getAgencyId());
    assertEquals("b",id.getId());
    
    id = AgencyAndId.convertFromString("a_b_c");
    assertEquals("a",id.getAgencyId());
    assertEquals("b_c",id.getId());
    
    try {
      AgencyAndId.convertFromString("ab");
      fail();
    } catch (IllegalArgumentException ex) {

    }
  }
  
  @Test
  public void testConvertToString() {
    
    AgencyAndId id = new AgencyAndId("a","b");
    assertEquals("a_b",AgencyAndId.convertToString(id));
  }
  
  @Test
  public void testSingleArgConstructor() {

	AgencyAndId aaid = new AgencyAndId("a_b");
    assertEquals("a",aaid.getAgencyId());
    assertEquals("b",aaid.getId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSingleArgConstructorInvalidArgumentException() {

	AgencyAndId fail = new AgencyAndId("invaildBecauseNoUnderscore");
  }

}