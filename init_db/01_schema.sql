CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE IF NOT EXISTS public.categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    level INT NOT NULL
);

CREATE TABLE IF NOT EXISTS public.quizzes (
    id SERIAL PRIMARY KEY,
    category_id INT REFERENCES public.categories(id),
    question TEXT NOT NULL,
    explanation TEXT,
    level INT NOT NULL
);

CREATE TABLE IF NOT EXISTS public.choices (
    id SERIAL PRIMARY KEY,
    quiz_id INT REFERENCES public.quizzes(id) ON DELETE CASCADE,
    choice_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    label VARCHAR(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.battles (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES public.users(id) ON DELETE CASCADE,
    category_id INT REFERENCES public.categories(id),
    total_count INT NOT NULL,
    correct_count INT NOT NULL
);

CREATE TABLE IF NOT EXISTS public.battles_quizzes (
    id SERIAL PRIMARY KEY,
    battle_id INT REFERENCES public.battles(id) ON DELETE CASCADE,
    quiz_id INT REFERENCES public.quizzes(id),
    user_choice_id INT REFERENCES public.choices(id)
);