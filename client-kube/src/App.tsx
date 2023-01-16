import "./App.css";

import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import EmployeeList from "./components/EmployeeList";

function App() {
  return (
    <div className="App">
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Typography variant="h2" component="div" sx={{ flexGrow: 1 }}>
            Kubernetes App Java
          </Typography>
        </AppBar>
      </Box>
      <EmployeeList />
    </div>
  );
}

export default App;
