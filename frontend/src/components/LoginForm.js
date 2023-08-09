import React, { useState } from 'react'

// The Login Form with all the components...
const LoginForm = ({ startLogin }) => {
  // States for tracking form input which are the email address and password
  const [ emailId, setEmail ] = useState('')
  const [ password, setPassword ] = useState('')

  // onSubmit event handler of this form
  const handleLogin = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const credentials = {
      emailId, password
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    startLogin(credentials)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setEmail('')
    setPassword('')
  }

  // // Typically keep id attributes on your HTML elements so that they can be styled using CSS
  // return (
  //   <form onSubmit={handleLogin} id='login-form'>
  //     <input 
  //       type='email'
  //       placeholder='Email' value={emailId}
  //       onChange={event => setEmail(event.target.value)}
  //       id='emailId'
  //       required
  //     />
        
  //     {/* Same as the above username input, except this one has the type password */}
  //     <input
  //       type='password'
  //       placeholder='Password'
  //       value={password}
  //       onChange={event => setPassword(event.target.value)}
  //       id='password'
  //       required
  //     />

  //     {/* Submit button for the form */}
  //     <button type='submit' id='login-submit'>LOGIN</button>
  //   </form>
  // )

  // Styled Form
  return (
    <div className='form-container'>
      <div className='form-box regular-shadow'>

        <div className='header-form'>
          <h4 className='text-primary text-center'>
            <i className='fa fa-user-circle' style={{fontSize:'110px', color: 'lightblue'}}></i>
          </h4>
          <div className='image'></div>
        </div>

        <div className='body-form'>
          <form onSubmit={handleLogin} id='login-form'>

            <div className='input-group mb-3'>
              <div className='input-group-prepend'>
                <span className='input-group-text'><i className='fa fa-user'></i></span>
              </div>
              <input 
                type='text'
                className='form-control'
                placeholder='Email Address'
                value={emailId}
                onChange={event => setEmail(event.target.value)}
                id='email'
                required
              />
            </div>

            <div className='input-group mb-3'>
              <div className='input-group-prepend'>
                <span className='input-group-text'><i className='fa fa-lock'></i></span>
              </div>
              <input
                type='password'
                className='form-control'
                placeholder='Password'
                value={password}
                onChange={event => setPassword(event.target.value)}
                id='password'
                required
              />
            </div>

            <button type='submit' className='btn btn-primary btn-block' id='login-submit'>LOGIN</button>
          </form>
        </div>
      </div>
    </div>   
  )
}

export default LoginForm