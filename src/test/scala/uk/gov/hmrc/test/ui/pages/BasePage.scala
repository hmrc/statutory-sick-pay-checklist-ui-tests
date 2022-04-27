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
import org.openqa.selenium.internal.FindsByClassName
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.util.Random

trait BasePage extends BrowserDriver with Matchers {
  val continueButton = "govuk-button"

  def findByID(id: String) = driver.findElement(By.id(id))

  def findByClassName(className: String) = driver.findElement(By.className(className))

  def click(id: String) = findByID(id).click()

  def enter(id: String, text: String) = findByID(id).sendKeys(text)

  def enterDate(id: String) = {
    findByID(id + ".day").sendKeys("1")
    findByID(id + ".month").sendKeys("1")
    findByID(id + ".year").sendKeys("2022")
  }
  val random = new Random

  def submitPage(): Unit =
    findByClassName(continueButton).click()

  def onPage(pageTitle: String): Unit =
    if (driver.getTitle != pageTitle + " - statutory-sick-pay-checklist-frontend - GOV.UK")
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '${driver.getTitle}' page."
      )
}

case class PageNotFoundException(s: String) extends Exception(s)
