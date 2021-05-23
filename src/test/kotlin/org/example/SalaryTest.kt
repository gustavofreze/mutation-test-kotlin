package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SalaryTest {
    companion object {
        private const val BASE_SALARY: Double = 5000.00
    }

    @Test
    fun `Salary Increase When Period Worked Is Long`() {
        val salary = Salary(Fee(), BASE_SALARY, 25)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5600.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Medium`() {
        val salary = Salary(Fee(), BASE_SALARY, 15)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5300.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Short`() {
        val salary = Salary(Fee(), BASE_SALARY, 5)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5150.0, actual)
    }

    @Test
    fun `Salary Increase When The Increase Is Not Applicable`() {
        val salary = Salary(Fee(), BASE_SALARY, 3)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(BASE_SALARY, actual)
    }
}