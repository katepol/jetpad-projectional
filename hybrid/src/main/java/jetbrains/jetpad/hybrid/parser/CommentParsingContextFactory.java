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
package jetbrains.jetpad.hybrid.parser;

import java.util.ArrayList;
import java.util.List;

public final class CommentParsingContextFactory implements ParsingContextFactory {

  public CommentParsingContextFactory() {
  }

  @Override
  public ParsingContext getParsingContext(List<Token> tokenList) {
    List<Token> list = new ArrayList<>();
    for (Token token : tokenList) {
      if (token instanceof CommentToken) {
        break;
      }
      list.add(token);
    }
    return new SimpleParsingContext(list);
  }

}
