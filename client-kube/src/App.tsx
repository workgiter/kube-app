import "./App.css";

import EmployeeList from "./components/EmployeeList";
import { useState } from "react";
import React from "react";
import TopAppBar from "./components/TopAppBar";

function App() {

  let [userDetails, setUserDetails] = useState({ username: "", password: "" })

  return (
    <div className="App">
      <TopAppBar userDetails={userDetails} setUserDetails={setUserDetails} />
      <EmployeeList userDetails={userDetails} />
    </div>
  );
}

export default App;
