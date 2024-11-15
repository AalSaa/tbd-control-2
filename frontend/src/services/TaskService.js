import httpClient from "../Utils/http-common";

export const postTask = async (taskData) => {
  try {
    const response = await httpClient.post("api/v1/tasks", taskData);
    return { data: response.data, status: response.status };
  } catch (error) {
    if (error.response) {
      console.error("Error en la respuesta del servidor:", error.response.data);
      return { data: error.response.data, status: error.response.status };
    } else if (error.request) {
      console.error("No se recibió respuesta del servidor:", error.request);
    } else {
      console.error("Error al hacer la solicitud:", error.message);
    }
    throw error;
  }
};

export const getAllTasks = async (userId) => {
  try {
    const response = await httpClient.get(`api/v1/tasks/user/${userId}`);
    return { data: response.data, status: response.status };
  } catch (error) {
    if (error.response) {
      console.error("Error en la respuesta del servidor:", error.response.data);
      return { data: error.response.data, status: error.response.status };
    } else if (error.request) {
      console.error("No se recibió respuesta del servidor:", error.request);
    } else {
      console.error("Error al hacer la solicitud:", error.message);
    }
    throw error;
  }
};

export const getTaskById = async (taskId) => {
  try {
    const response = await httpClient.get(`api/v1/tasks/${taskId}`);
    return { data: response.data, status: response.status };
  } catch (error) {
    if (error.response) {
      console.error("Error en la respuesta del servidor:", error.response.data);
      return { data: error.response.data, status: error.response.status };
    } else if (error.request) {
      console.error("No se recibió respuesta del servidor:", error.request);
    } else {
      console.error("Error al hacer la solicitud:", error.message);
    }
    throw error;
  }
};

export const updateTask = async (taskData) => {
  try {
    const response = await httpClient.put("api/v1/tasks", taskData);
    alert("Tarea actualizada correctamente");
    return { data: response.data, status: response.status };
  } catch (error) {
    if (error.response) {
      console.error("Error en la respuesta del servidor:", error.response.data);
      return { data: error.response.data, status: error.response.status };
    } else if (error.request) {
      console.error("No se recibió respuesta del servidor:", error.request);
    } else {
      console.error("Error al hacer la solicitud:", error.message);
    }
    throw error;
  }
};

export const deleteTask = async (taskId) => {
  try {
    const response = await httpClient.delete(`api/v1/tasks/${taskId}`);
    alert("Tarea eliminada");
    return { data: response.data, status: response.status };
  } catch (error) {
    if (error.response) {
      console.error("Error en la respuesta del servidor:", error.response.data);
      return { data: error.response.data, status: error.response.status };
    } else if (error.request) {
      console.error("No se recibió respuesta del servidor:", error.request);
    } else {
      console.error("Error al hacer la solicitud:", error.message);
    }
    throw error;
  }
};
