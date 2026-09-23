# PawHome Backend (Spring Boot)

REST API for the PawHome animal adoption platform.

## API

- `GET /api/animals` — list available pets (optional `?species=Dog`)
- `GET /api/animals/{id}` — pet details
- `POST /api/adoptions` — submit adoption request

## Run locally

```bash
mvn spring-boot:run
```

Server: `http://localhost:8080`

## Run with Docker

```bash
docker build -t animal-adoption-backend .
docker run -p 8080:8080 -e PORT=8080 animal-adoption-backend
```

## Deploy on Render (Docker)

1. Push this repo to GitHub: [animal_adoption_backend](https://github.com/Suryakant2010067/animal_adoption_backend)
2. Open [Render Dashboard](https://dashboard.render.com/) → **New** → **Blueprint**
3. Connect the GitHub repo and use the included `render.yaml`, **or** create a **Web Service** manually:
   - **Environment:** Docker
   - **Dockerfile path:** `./Dockerfile`
   - **Health check path:** `/api/animals`
   - **Plan:** Free
4. After deploy, your API base URL will be:

   `https://animal-adoption-backend.onrender.com/api`

   (If you choose a different service name on Render, use that hostname instead.)

5. Set the frontend env variable:

   `VITE_API_BASE=https://animal-adoption-backend.onrender.com/api`

**Note:** Free tier may sleep after inactivity; the first request can take ~30 seconds to wake up. H2 in-memory data resets when the service restarts.
