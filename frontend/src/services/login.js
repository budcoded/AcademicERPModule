import axios from 'axios'

// URL for faculty login
const loginBaseUrl = `http://localhost:8080/esd_project_backend-1.0-SNAPSHOT/api/faculty/login`
const login = async (credentials) => {
  const response = await axios.post(loginBaseUrl, credentials)
  return response.data
}

const exportObject = { login }
export default exportObject