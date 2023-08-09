import React, { useState } from 'react'

/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const UpdateTA = ({ update ,students ,courses }) => {
  // States for tracking form input which are the email address and password
  const [ student ,setstudent ] = useState('')
  const [ course, setcourse ] = useState('')

  // onSubmit event handler of this form
  const handleUpdate = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const details = {
      student, course
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    update(details)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    // setstudent('')
    // setcourse('')
  }

  // Typically keep id attributes on your HTML elements so that they can be styled using CSS
  return (
    <form onSubmit={handleUpdate} id='login-form'>
      <label>Student:</label>
      <select value ={student} onChange={event => setstudent(event.target.value)}>
        {students.map((s) => {
            return<option value={s.studentId} key={s.id}>{s.firstName}</option>
        })}
      </select>

      <label>Course:</label>
      <select value ={course} onChange={event => setcourse(event.target.value)}>
        {courses.map((c) => {
            return<option value={c.courseId} key={c.courseId}>{c.courseName}</option>
        })}
      </select>
      
      {/* Submit button for the form */}
      <button type='submit' id='login-submit'>Assign TA</button>
    </form>
  )
}

export default UpdateTA