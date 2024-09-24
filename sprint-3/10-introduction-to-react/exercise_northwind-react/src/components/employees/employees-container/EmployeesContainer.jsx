import { useState } from "react"
import { employees } from "../../../data"
import EmployeeRow from "../employee-row/EmployeeRow"
import './EmployeesContainer.css'

export default function EmployeesContainer()
{
    const [selectedEmployee, setSelectedEmployee] = useState("None Selected"); 

    const employeeSelected = (firstName, lastName) =>
    {
        setSelectedEmployee(`${firstName} ${lastName}`);
    }

    return(
        <>
        <h5 className="container">Selected Employee: {selectedEmployee}</h5>
        <main className="container mt-4 employees-container" id="employees-container">
        {
            employees.map((employee) => (
                <EmployeeRow key={employee.employeeId}
                    firstName = {employee.firstName}
                    lastName = {employee.lastName}
                    id = {employee.employeeId}
                    title = {employee.title}
                    onEmployeeSelected={employeeSelected}
                ></EmployeeRow>
            ))
        }
        </main>
      </>
    )
}