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
    

// url localhost:8000/author/asdasd213123
function App() {
  // const navigate = useNavigate();
  // navigate("/author/asdasd");
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Navigate to="/author"></Navigate>}/>
          <Route path="/author" exact element={<Main />}/>
          <Route path="/author/new" element={ <Create />} />
          <Route path="/author/:id" element={<Detail />}/>
          <Route path="/author/:id/edit" element={<Update/>}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}
    
export default App;