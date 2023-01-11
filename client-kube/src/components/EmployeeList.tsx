import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import { temp, IEmployeeList } from "../interfaces/IEmployeeList";

const SERVER_URL = 'http://172.21.3.173:30011/people/';

const EmployeeList = () => {
    //console.log(temp)
    let [employeeArray, setEmployeeArray] = useState(temp)

    const getEmplyees = () => {
        fetch(SERVER_URL)
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