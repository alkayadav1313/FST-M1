import options as options
from selenium import webdriver

driver = webdriver.Chrome()


def openURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    # driver = webdriver.Chrome(options=options)
    driver.get('https://alchemy.hguy.co/lms')


def verifyPageTitle():
    get_title = driver.title
    print('Page title is: ', get_title)
    assert get_title == 'Alchemy LMS – An LMS Application'
    print('Assertion completed successfully')

def closeBrowser():
    driver.quit()

# Open the URL
openURL()

# Verify the Page Title
verifyPageTitle()

# Close the browser
closeBrowser()