import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import EmployeeImput from "./EmployeeImput";
import { temp } from "../interfaces/IEmployeeList";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";

const SERVER_URL = "http://server.test:30011/people/";
//for out of minikube testing 'http://localhost:8080/people/'; 

const EmployeeList = () => {
    let [employeeArray, setEmployeeArray] = useState(temp)
    let [pageNum, setPageNum] = useState(0)
    let pageLen = 15;

    const getEmplyees = () => {
        fetch(SERVER_URL)
            .then(response => response.json())
            .then(data => {
                setEmployeeArray(data);
            })
            .catch(error => { });
    }

    useEffect(() => {
        getEmplyees()
    }, [])

    const addEmployee = (name: string, email: string, age: number) => {
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
                    "age": age
                }
            )
        }).then(() => { getEmplyees() })
    }

    let backPage = () => {
        if (pageNum > 0) { setPageNum(pageNum - 1) }
    }

    let forwardPage = () => {
        if ((pageNum + 1) * pageLen <= employeeArray.employees.length) {
            setPageNum(pageNum + 1)
        }
    }

    let css = {
        display: "grid",
        gridTemplateColumns: "repeat(auto-fill, 301px)", //the width of the card 
        justifyContent: "center",
        gridGap: "20px",
    }

    return (
        <div>
            <EmployeeImput addEmployee={addEmployee} />
            <p></p>
            <button onClick={backPage}>previous page</button>
            <button onClick={forwardPage}>next page</button>
            <Box sx={css}>
                {employeeArray.employees
                    .slice(pageNum * pageLen, pageNum * pageLen + pageLen)
                    .map((employee, index): any => {
                        return (
                            <Grid item xs>
                                <EmployeeCard
                                    key={index}
                                    employee={employee}
                                />
                            </Grid>
                        )
                    })}
            </Box>
            <button onClick={backPage}>previous page</button>
            <button onClick={forwardPage}>next page</button>
        </div>
    )
}



export default EmployeeList