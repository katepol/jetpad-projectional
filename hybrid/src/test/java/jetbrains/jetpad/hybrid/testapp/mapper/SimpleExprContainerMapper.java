/*
 * Copyright 2012-2016 JetBrains s.r.o
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
package jetbrains.jetpad.hybrid.testapp.mapper;

import com.google.common.base.Function;
import jetbrains.jetpad.cell.HorizontalCell;
import jetbrains.jetpad.hybrid.HybridEditorSpec;
import jetbrains.jetpad.hybrid.SimpleHybridSynchronizer;
import jetbrains.jetpad.hybrid.testapp.model.Expr;
import jetbrains.jetpad.hybrid.testapp.model.SimpleExprContainer;
import jetbrains.jetpad.mapper.Mapper;

public class SimpleExprContainerMapper extends Mapper<SimpleExprContainer, HorizontalCell> {
  public final SimpleHybridSynchronizer<Expr> hybridSync;
  public final HybridEditorSpec<Expr> hybridSyncSpec;

  public SimpleExprContainerMapper(SimpleExprContainer source) {
    super(source, new HorizontalCell());
    hybridSyncSpec = new ExprHybridEditorSpec();
    hybridSync = new SimpleHybridSynchronizer<>(this, getSource().expr, getTarget(), hybridSyncSpec,
      new Function<Integer, Object>() {
        @Override
        public Object apply(Integer input) {
          return String.valueOf(input);
        }
      });
    hybridSync.setMapperFactory(new ExprMapperFactory());
  }

  @Override
  protected void registerSynchronizers(SynchronizersConfiguration conf) {
    super.registerSynchronizers(conf);

    conf.add(hybridSync);
  }
}
