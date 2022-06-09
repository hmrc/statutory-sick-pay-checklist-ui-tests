/*
 * Copyright 2022 HM Revenue & Customs
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

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.LocalDate
import scala.util.Random

trait BasePage extends BrowserDriver with Matchers {
  val continueButton = "govuk-button"

  def findByID(id: String) = driver.findElement(By.id(id))

  def findByClassName(className: String) = driver.findElement(By.className(className))

  def click(id: String) = findByID(id).click()

  def enter(id: String, text: String) = findByID(id).sendKeys(text)

  def enterDate(id: String, date: LocalDate) = {
    findByID(id + ".day").sendKeys(date.getDayOfMonth.toString)
    findByID(id + ".month").sendKeys(date.getMonthValue.toString)
    findByID(id + ".year").sendKeys(date.getYear.toString)
  }
  val random = new Random

  def submitPage(): Unit =
    findByClassName(continueButton).click()

  def onPage(pageTitle: String, section: Option[String] = None): Unit =
    if (
      driver.getTitle != pageTitle + section
        .map(" - " + _)
        .getOrElse("") + " - Ask your employer for statutory sick pay - GOV.UK"
    )
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '${driver.getTitle}' page."
      )
}

case class PageNotFoundException(s: String) extends Exception(s)
