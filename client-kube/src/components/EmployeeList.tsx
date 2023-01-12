import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import EmployeeImput from "./EmployeeImput";
import { temp, IEmployeeList } from "../interfaces/IEmployeeList";

const SERVER_URL = 'http://172.21.3.173:30011/people/';  //'http://localhost:8080/people/'; 

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

    const addEmployee = (name : string, email : string, age : number) => {
        fetch(SERVER_URL, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    "name": name, 
                    "email": email,
                    "age":age
                }
            )
        }).then(()=>{getEmplyees()})
    }

    return(
        <div>
            <EmployeeImput addEmployee={addEmployee}  />
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