from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webelement import WebElement
from selenium.webdriver.support import wait, expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)


def openURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    
    driver.get('https://alchemy.hguy.co/lms')


def verifyInfoBoxText():
    element = driver.find_element(By.XPATH, "//h3[@class='uagb-ifb-title' and text()=' Actionable Training ']")
    actions = ActionChains(driver)
    actions.move_to_element(element).perform()
    driver.execute_script("arguments[0].scrollIntoView();", element)

    wait.until(expected_conditions.presence_of_element_located(
        (By.XPATH, "//h3[@class='uagb-ifb-title' and text()=' Actionable Training ']")))
    infoBoxTitle = element.text
    print("The first info box title is: ", infoBoxTitle)
    assert infoBoxTitle == 'Actionable Training'
    print('Assertion completed successfully!')


def closeBrowser():
    driver.quit()

# Open the browser
openURL()

# Verify the InfoBox text
verifyInfoBoxText()

#Close the browser
closeBrowser()
