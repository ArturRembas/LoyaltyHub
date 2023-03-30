<template>
  <div>
    <form @submit.prevent="registerCustomer">
      <input v-model="customer.name" placeholder="Nome" />
      <input v-model="customer.email" placeholder="Email" />
      <!-- Aggiungi altri campi per gli attributi del cliente -->
      <button type="submit">Registrati</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      customer: {
        name: '',
        email: '',
        // altri attributi del cliente
      },
    };
  },
  methods: {
    async registerCustomer() {
      try {
        await axios.post('http://localhost:8080/register', this.customer);
        // Gestisci la risposta positiva, ad esempio mostrando un messaggio di successo
      } catch (error) {
        // Gestisci gli errori, ad esempio mostrando un messaggio di errore
      }
    },
  },
};
</script>

<style scoped>
/* Aggiungi gli stili CSS per il componente qui */
</style>
