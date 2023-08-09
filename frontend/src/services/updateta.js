import axios from 'axios'

// URL for assigning student as a teaching assistant for a course
const updateBaseUrl = `http://localhost:8080/esd_project_backend-1.0-SNAPSHOT/api/faculty/addTA`
const update = async (details) => {
  const response = await axios.post(`${updateBaseUrl}?student_id=${details.student}&course_id=${details.course}`)
  return response.data
}

// URL for getting the course list that the faculty teaches
const getcourseurl = `http://localhost:8080/esd_project_backend-1.0-SNAPSHOT/api/course/get`
const getcourse = async () => {
  const response = await axios.get(getcourseurl)
  return response.data
}

// URL for getting all the student list
const getstudenturl = `http://localhost:8080/esd_project_backend-1.0-SNAPSHOT/api/student/get`
const getstudent = async () => {
  const response = await axios.get(getstudenturl)
  return response.data
}

const exportObject = { update, getcourse, getstudent }
export default exportObject