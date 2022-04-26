// import logo from './logo.svg';
import React from 'react';
import './App.css';
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
  // useNavigate
} from "react-router-dom";
import Main from './views/Main';
import Detail from './views/Detail';
import Update from './views/Update'; 
import Create from './views/Create'; 
    

// url localhost:8000/player/asdasd213123
function App() {
  // const navigate = useNavigate();
  // navigate("/player/asdasd");
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Navigate to="/player"></Navigate>}/>
          <Route path="/player" exact element={<Main />}/>
          <Route path="/player/new" element={ <Create />} />
          <Route path="/player/:id" element={<Detail />}/>
          <Route path="/player/:id/edit" element={<Update/>}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}
    
export default App;