/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

object WhatIsYourClockOrPayrollNumber extends BasePage {

  val whatIsYourClockOrPayrollNumber = "What is your clock or payroll number?"

  def provideNumber: CheckYourAnswers.type = {
    onPage(whatIsYourClockOrPayrollNumber, Some(Sections.employmentDetails))
    findByID("value").sendKeys("0000000")
    submitPage()
    CheckYourAnswers
  }
}
