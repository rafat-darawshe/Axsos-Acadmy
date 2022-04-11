    
import React, {useState} from 'react'
import './Fun.css';

const Fun = (props) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  
  const createUser = (e) => {
      e.preventDefault();
      const newUser = { firstName, lastName, email, password, confirmPassword };
      console.log("Welcome", newUser);
  };
  
  return(
    <div className='rafat'>
      <form onSubmit={ createUser }>
          <div>
              <label>First Name: </label> 
              <input type="text" onChange={ (e) => setFirstName(e.target.value) } value={ firstName } />
          </div>
          <div>
              <label>Last Name: </label> 
              <input type="text" onChange={ (e) => setLastName(e.target.value) } value={ lastName } />
          </div>
          <div>
              <label>Email Address: </label> 
              <input type="text" onChange={ (e) => setEmail(e.target.value) } value={ email } />
          </div>
          <div>
              <label>Password: </label>
              <input type="text" onChange={ (e) => setPassword(e.target.value) } value={ password } />
          </div>
          <div>
              <label>Confirm Password: </label>
              <input type="text" onChange={ (e) => setConfirmPassword(e.target.value) } value={ confirmPassword } />
          </div>
          <input type="submit" value="Create User" />
      </form>
      <div>
          <p>First Name: {firstName} </p>
          <p>Last Name: {lastName} </p>
          <p>Email: {email} </p>
          <p>Password: {password} </p>
          <p>Confirm Password: {confirmPassword} </p>
      </div>
    </div>
  );  
};
export default Fun



// class Personcard extends Component {
//     render() { 
//     return( 
//         <div>
//             <h1>{ this.props.firstName } { this.props.lastName }</h1>
//             <h5>Age: { this.props.age }</h5>
//             <h5>Hair Color: { this.props.hairColor }</h5>
//         </div>
//     );    
// }
// }
    
// export default Personcard;