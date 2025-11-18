-- Truncate all tables and reset identities, then load initial CSV data.
TRUNCATE TABLE public.battles_quizzes, public.battles, public.choices, public.quizzes, public.categories, public.users RESTART IDENTITY CASCADE;

-- Users
COPY public.users (id, name)
FROM '/docker-entrypoint-initdb.d/csv/users.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);

-- Categories
COPY public.categories (id, name, description, level)
FROM '/docker-entrypoint-initdb.d/csv/categories.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);

-- Quizzes
COPY public.quizzes (id, category_id, question, explanation, level)
FROM '/docker-entrypoint-initdb.d/csv/quizzes.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);

-- Choices (4 per quiz)
COPY public.choices (id, quiz_id, choice_text, is_correct, label)
FROM '/docker-entrypoint-initdb.d/csv/choices.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);

-- Battles
COPY public.battles (id, user_id, total_count, correct_count)
FROM '/docker-entrypoint-initdb.d/csv/battles.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);

-- Battles <-> Quizzes mapping
COPY public.battles_quizzes (battle_id, quiz_id, user_choice_id)
FROM '/docker-entrypoint-initdb.d/csv/battles_quizzes.csv'
WITH (
    FORMAT csv,
    HEADER true,
    ENCODING 'UTF8'
);