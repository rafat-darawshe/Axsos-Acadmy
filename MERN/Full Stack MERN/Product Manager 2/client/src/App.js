import logo from './logo.svg';
import React from 'react';
import './App.css';
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
  useNavigate
} from "react-router-dom";
import Main from './views/Main';
import Detail from './views/Detail';
    

// url localhost:8000/product/asdasd213123
function App() {
  // const navigate = useNavigate();
  // navigate("/product/asdasd");
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Navigate to="/product"></Navigate>}/>
          <Route path="/product" exact element={<Main />}/>
          <Route path="/product/:id" element={<Detail />}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}
    
export default App;