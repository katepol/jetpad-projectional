/*
 * Copyright 2012-2014 JetBrains s.r.o
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.jetpad.cell.view;

import jetbrains.jetpad.base.Registration;
import jetbrains.jetpad.cell.*;
import jetbrains.jetpad.projectional.view.*;

public class MapperCell2View {
  public static Registration map(final CellContainer cellContainer, View root, View targetView, View popupView) {
    final CellContainerToViewMapper mapper = new CellContainerToViewMapper(cellContainer, root, targetView, popupView);
    mapper.attachRoot();
    return new Registration() {
      @Override
      public void remove() {
        mapper.detachRoot();
      }
    };
  }

  public static Registration map(final CellContainer cellContainer, ViewContainer container) {
    return map(cellContainer, container.root(), container.contentRoot(), container.decorationRoot());
  }
}