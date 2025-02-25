package Util;

import org.openqa.selenium.WebElement;

public class CheckBoxUtils {

    // Select checkbox if not already selected
    public static void selectCheckBox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Deselect checkbox if selected
    public static void deselectCheckBox(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Toggle checkbox (Select if not selected, Deselect if selected)
    public static void toggleCheckBox(WebElement checkbox) {
        checkbox.click();
    }

    // Check if checkbox is selected
    public static boolean isCheckBoxSelected(WebElement checkbox) {
        return checkbox.isSelected();
    }
}
