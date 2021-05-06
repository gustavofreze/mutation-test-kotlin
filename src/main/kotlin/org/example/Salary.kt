package org.example

import kotlin.math.round

class Salary(
    private var fee: Fee,
    private var baseSalary: Double,
    private var periodWorked: Int
) {
    private companion object {
        const val LONG_PERIOD: Int = 25

        const val SHORT_PERIOD: Int = 5

        const val MIDDLE_PERIOD: Int = 15
    }

    private var salaryWithIncrease: Double = this.baseSalary

    fun applyIncreaseByPeriod() {
        if (this.periodWorked >= LONG_PERIOD) {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.baseSalary, this.fee.maximumIncrease)
            return
        }

        if (this.periodWorked >= MIDDLE_PERIOD) {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.baseSalary, this.fee.mediumIncrease)
            return
        }

        if (this.periodWorked >= SHORT_PERIOD) {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.baseSalary, this.fee.minimumIncrease)
        }
    }

    private fun calculateIncreaseAmount(baseSalary: Double, fee: Double): Double {
        return round((baseSalary / 100) * fee)
    }

    fun getSalaryWithIncrease(): Double {
        return this.salaryWithIncrease
    }
}