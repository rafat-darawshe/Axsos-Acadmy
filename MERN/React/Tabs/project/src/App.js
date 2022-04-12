import logo from './logo.svg';
import './App.css';
import {useState} from "react";


import Tabs from './component/Tabs';



function App() {
  return (
    <div className="App">
      <Tabs
        tabItems={[
          {tab: "Tab1", content: "Tab1 Content"},
          {tab: "Tab2", content: "Tab2 Content"},
          {tab: "Tab3", content: "Tab3 Content"}
        ]}


      />
    </div>
  );
}

export default App;
