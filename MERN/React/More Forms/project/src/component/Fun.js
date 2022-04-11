    
import React, {useState} from 'react'
import './Fun.css';

const Fun = (props) => {
  const [firstName, setFirstName] = useState("");
  const [firstNameError, setFirstNameError] = useState("");

  const [lastName, setLastName] = useState("");
  const [lastNameError, setLastNameError] = useState("");

  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState("");

  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState("");

  const [confirmPassword, setConfirmPassword] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");

  const createUser = (e) => {
    e.preventDefault();
    const newUser = { firstName, lastName, email, password, confirmPassword };
    console.log("Welcome", newUser);
  }
  const handelFirstName = (e)=>{
    setFirstName(e.target.value);
    if(e.target.value.length < 2){
        setFirstNameError("First Name must be 2 characters or longer!");
    } else{
        setFirstNameError("");
        setFirstName(e.target.value);
    }
  }
  const handelLastName = (e)=>{
    setLastName(e.target.value);
    if(e.target.value.length < 2){
        setLastNameError("Last Name must be 2 characters or longer!");
    } else{
        setLastNameError("");
        setLastName(e.target.value);
    }
  }
  const handelEmail = (e)=>{
    setEmail(e.target.value);
    if(e.target.value.length < 5){
        setEmailError("Email Name must be 5 characters or longer!");
    } else{
        setEmailError("");
        setEmail(e.target.value);
    }
  }
  const handlePassword = (e) => {
    setPassword(e.target.value);
    if(e.target.value.length < 8) {
        setPasswordError("password must be at least 8 characters.");
    }
    else{
        setPasswordError("");
        setPassword(e.target.value);
    }
};

const handleConfirmPassword = (e) => {
    setConfirmPassword(e.target.value);
    if(e.target.value != password) {
        setConfirmPasswordError("Passwords must match");
    }
    else{
        setConfirmPasswordError("");
    }
};
  
  return(
    <div className='rafat'>
      <form onSubmit={ createUser }>
          <div>
              <label>First Name: </label> 
              <input type="text" onChange={ handelFirstName } value={ firstName } />
              {
                    firstNameError ?
                    <p style={{color:'red'}}>{ firstNameError }</p> :
                    ''
                }
          </div>
          <div>
              <label>Last Name: </label> 
              <input type="text" onChange={ handelLastName } value={ lastName } />
              {
                    lastNameError ?
                    <p style={{color:'red'}}>{ lastNameError }</p> :
                    ''
                }
          </div>
          <div>
              <label>Email Address: </label> 
              <input type="text" onChange={ handelEmail } value={ email } />
              {
                    emailError ?
                    <p style={{color:'red'}}>{ emailError }</p> :
                    ''
                }
          </div>
          <div>
              <label>Password: </label>
              <input type="text" onChange={ handlePassword } value={ password } />
              {
                    passwordError ?
                    <p style={{color:'red'}}>{ passwordError }</p> :
                    ''
                }
          </div>
          <div>
              <label>Confirm Password: </label>
              <input type="text" onChange={ handleConfirmPassword } value={ confirmPassword } />
              {
                    confirmPasswordError ?
                    <p style={{color:'red'}}>{ confirmPasswordError }</p> :
                    ''
                }
          </div>
          <input type="submit" value="Create User" />
      </form>
      {/* <div>
          <p>First Name: {firstName} </p>
          <p>Last Name: {lastName} </p>
          <p>Email: {email} </p>
          <p>Password: {password} </p>
          <p>Confirm Password: {confirmPassword} </p>
      </div> */}
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