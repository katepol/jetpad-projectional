/*
 * Copyright 2012-2015 JetBrains s.r.o
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
package jetbrains.jetpad.projectional.demo.hybridExpr.model;

import jetbrains.jetpad.model.children.ChildProperty;
import jetbrains.jetpad.model.property.Property;
import jetbrains.jetpad.projectional.demo.hybridExpr.model.types.Type;
import jetbrains.jetpad.projectional.demo.hybridExpr.model.types.Types;

public class DotExpression extends Expression {
  public final Property<Expression> operand = new ChildProperty<ExpressionNode, Expression>(this);
  public final Property<Operation> operation = new ChildProperty<ExpressionNode, Operation>(this);

  @Override
  public Type getType() {
    if (operand.get() == null) return Types.OBJECT;
    if (operation.get() == null) return Types.OBJECT;
    return operation.get().getType(operand.get().getType());
  }
}