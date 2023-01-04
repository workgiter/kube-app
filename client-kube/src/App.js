
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import './App.css';

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
    </div>
  );
}

export default App;
