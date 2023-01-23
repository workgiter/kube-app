import { useEffect, useState } from "react";

import EmployeeCard from "./EmployeeCard";
import { temp } from "../interfaces/IEmployeeList";
import Grid from "@mui/material/Grid";
import PageBar from "./PageBar";
import NewEmployeeCard from "./NewEmployeeCard";

const SERVER_URL = "http://server.test:30011/people/";
//for out of minikube testing 
//const SERVER_URL = 'http://localhost:8080/people/';

const EmployeeList = () => {
    let [employeeArray, setEmployeeArray] = useState(temp)
    let [editIndex, setEditIndex] = useState(-1)
    let [pageNum, setPageNum] = useState(0)
    const pageLen = 15;

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

    const addEmployee = (id: string, name: string, email: string, age: number) => {
        console.log("called")
        console.log(id)
        console.log(name)
        console.log(email)
        console.log(age)
        let useServerURL;
        let empData;
        if (id === "asdf") {
            useServerURL = SERVER_URL
            empData = {
                "name": name,
                "email": email,
                "age": age
            }
        } else {
            useServerURL = SERVER_URL + "edit"
            empData = {
                "id": id,
                "name": name,
                "email": email,
                "age": age
            }
            setEditIndex(-1)
        }
        fetch(useServerURL, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(empData)
        }).then(() => { getEmplyees() })
    }

    let backPage = (pageNum: number) => {
        if (pageNum > 0) { setPageNum(pageNum - 1) }
    }

    let forwardPage = (pageNum: number) => {
        if ((pageNum + 1) * pageLen <= employeeArray.employees.length + 1) {
            setPageNum(pageNum + 1)
        }
    }

    // let css = {
    //     display: "grid",
    //     gridTemplateColumns: "repeat(auto-fill, 301px)", //the width of the card 
    //     justifyContent: "center",
    //     gridGap: "20px",
    // }

    return (
        <div>
            <p></p>
            <PageBar
                backPage={backPage}
                forwardPage={forwardPage}
                pageNum={pageNum}
            />
            <Grid container spacing={1}>
                {employeeArray.employees
                    .concat([{ id: "asdf", name: "", email: "", age: 0 }])
                    .slice(pageNum * pageLen, pageNum * pageLen + pageLen)
                    .map((employee, index): any => {
                        return (
                            <Grid item xs={12} sm={6} md={4}>
                                {((pageNum * pageLen + index === employeeArray.employees.length) || (pageNum * pageLen + index === editIndex)) ?
                                    <NewEmployeeCard
                                        addEmployee={addEmployee}
                                        employee={employee}
                                        key={pageNum * pageLen + index}
                                        setEditIndex={(x: number) => setEditIndex(x)}
                                    /> :
                                    <EmployeeCard
                                        key={pageNum * pageLen + index}
                                        index={pageNum * pageLen + index}
                                        setEditIndex={(x: number) => setEditIndex(x)}
                                        employee={employee}
                                    />}
                            </Grid>
                        )
                    })
                }
            </Grid>
            <PageBar
                backPage={backPage}
                forwardPage={forwardPage}
                pageNum={pageNum}
            />
            <p></p>
        </div>
    )
}



export default EmployeeList