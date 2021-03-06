//   Copyright 2014 Commonwealth Bank of Australia
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package au.com.cba.omnia.thermometer.tools

import au.com.cba.omnia.thermometer.test.Spec

class ErrorsSpec extends Spec { def is = s2"""

Errors Properties
=================

  render contains class name                $className
  render contains message                   $message

"""

  def className = prop((t: Throwable) => {
    val rendered = Errors.render(t)
    rendered.contains(t.getClass.getName)
  })

  def message = prop((message: String) => {
    val t = new Throwable(message)
    val rendered = Errors.render(t)
    rendered.contains(t.getMessage)
  })
}
