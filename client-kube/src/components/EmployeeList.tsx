import React, { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import { IEmployeeList, IEmployee , temp } from "../interfaces/IEmployeeList";

const EmployeeList = () => {
    //console.log(temp)
    let [employeeArray, setEmployeeArray] = useState(temp)

    const getEmplyees = () => {
        fetch('http://localhost:54490/people/')
        .then(response => response.json())
        .then(data => {
            setEmployeeArray(data);
        })
        .catch(error => {});
    }

    useEffect(() =>{
        getEmplyees()
    }, [])

    return(
        <div>
            {employeeArray.employees.map((employee, index):any => {
                return(
                    <EmployeeCard 
                        key={index}
                        employee={employee}
                    />
                )
            })}
        </div>
    )
}



export default EmployeeList