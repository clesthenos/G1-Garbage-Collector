/*
 *  This file is part of the Jikes RVM project (http://jikesrvm.org).
 *
 *  This file is licensed to You under the Eclipse Public License (EPL);
 *  You may not use this file except in compliance with the License. You
 *  may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/eclipse-1.0.php
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package org.mmtk.plan.region;

import org.mmtk.plan.StopTheWorldConstraints;
import org.mmtk.policy.RegionSpace;
import org.vmmagic.pragma.*;

/**
 * This class and its subclasses communicate to the host VM/Runtime any features
 * of the selected plan that it needs to know. This is separate from the main
 * Plan/PlanLocal class in order to bypass any issues with ordering of static
 * initialization.
 */
@Uninterruptible
public class RegionConstraints extends StopTheWorldConstraints {
  @Override
  public boolean movesObjects() {
    return true;
  }

  @Override
  public int gcHeaderBits() {
    return RegionSpace.LOCAL_GC_BITS_REQUIRED;
  }

  @Override
  public int gcHeaderWords() {
    return RegionSpace.GC_HEADER_WORDS_REQUIRED;
  }

  @Override
  public int numSpecializedScans() {
    return 2;
  }
}
