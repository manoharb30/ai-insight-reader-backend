# AI Insight Reader Backend

A Spring Boot-based backend for AI-powered document summarization and Q&A. This backend supports secure document uploads, OpenAI integration, role-based access, and modular billing with credit or subscription support.

## 🧱 Tech Stack
- Java 17
- Spring Boot 3.x
- PostgreSQL
- OpenAI Java SDK
- Apache Tika / POI (for file parsing)
- Docker
- JWT Authentication
- Modular Strategy Pattern

## 🚀 Features
- User registration with email verification
- JWT-based login and secure session
- Upload support for PDF, DOCX, XLSX
- AI-powered document summarization (GPT-3.5 / GPT-4)
- Dynamic billing strategy (subscription or credit)
- Role management: Free, Premium, Admin
- Config-driven feature flags

## 🛠️ Setup Instructions

### 1. Clone the repo
```bash
git clone https://github.com/manoharb30/ai-insight-reader-backend.git
cd ai-insight-reader-backend
